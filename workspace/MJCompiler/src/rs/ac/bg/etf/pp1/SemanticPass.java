package rs.ac.bg.etf.pp1;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	boolean errorDetected = false;

	Obj currentMethod = null;
	boolean returnFound = false;
	boolean mainFound = false;

	int globalVarDeclCount;
	int constDeclCount;
	int localVarDeclCount;

	ArrayList<String> varNames;
	ArrayList<Integer> varKinds;

	ArrayList<String> constNames;
	ArrayList<Integer> constVals;
	ArrayList<Struct> constKinds;
	Integer constVal;
	String constName;
	Struct constKind;

	ArrayList<Struct> assignTypes;
	ArrayList<String> assignNames;

	public static final Struct boolType = new Struct(Struct.Bool);

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(Program program) {

		globalVarDeclCount = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		if (!mainFound) {
			report_error("Nije pronadjena main metoda!", null);
		}
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getPName(), Tab.noType);
		Tab.openScope();
	}

	public void visit(SingleVar singleVar) {
		varNames = new ArrayList<>();
		varKinds = new ArrayList<>();
		VarName varName = singleVar.getVarName();
		if (varName instanceof VarSingleName) {
			varNames.add(((VarSingleName) varName).getName());
			varKinds.add(0);
		} else if (varName instanceof VarArrayName) {
			varNames.add(((VarArrayName) varName).getName());
			varKinds.add(1);
		}
	}

	public void visit(VarDecl varDecl) {
		Struct type = ((VarDeclaration) varDecl).getType().struct;
		for (int i = 0; i < varNames.size(); i++) {
			if (Tab.find(varNames.get(i)).equals(Tab.noObj)) {
				if (varKinds.get(i) == 0) {
					Tab.insert(Obj.Var, varNames.get(i), type);
					report_info("Deklarisana promenljiva " + varNames.get(i), varDecl);
				} else {

					Tab.insert(Obj.Var, varNames.get(i), new Struct(Struct.Array, type));
					report_info("Deklarisana nizovna promenljiva " + varNames.get(i), varDecl);
				}
			} else {
				report_error("Promenljiva " + varNames.get(i) + "je vec deklarisana", varDecl);
			}
		}
	}

	public void visit(VarList varList) {
		VarName varName = varList.getVarName();
		if (varName instanceof VarSingleName) {
			varNames.add(((VarSingleName) varName).getName());
			varKinds.add(0);
		} else if (varName instanceof VarArrayName) {
			varNames.add(((VarArrayName) varName).getName());
			varKinds.add(1);
		}
	}

	public void visit(ConstDecl constDecl) {
		for (int i = 0; i < constNames.size(); i++) {
			if (Tab.find(constNames.get(i)).equals(Tab.noObj)) {
				if (!constDecl.getType().struct.equals(constKinds.get(i))) {
					report_error("Vrednost konstante " + constNames.get(i) + " je pogresnog tipa!", constDecl);
				} else {
					Obj new_node = Tab.insert(Obj.Con, constNames.get(i), constKinds.get(i));
					new_node.setAdr(constVals.get(i));
					constDeclCount++;
					report_info("Deklarisana konstanta " + constNames.get(i), constDecl);
				}
			} else {
				report_error("Konstanta " + constNames.get(i) + "je vec deklarisana", constDecl);
			}
		}
	}

	public void visit(GlobalConstDeclList constList) {
		constNames.add(this.constName);
		constVals.add(this.constVal);
		constKinds.add(this.constKind);
	}

	public void visit(GlobalConst globalConst) {
		constNames = new ArrayList<>();
		constVals = new ArrayList<>();
		constKinds = new ArrayList<>();

		constNames.add(this.constName);
		constVals.add(this.constVal);
		constKinds.add(this.constKind);
	}

	public void visit(ConstName constName) {
		this.constName = constName.getConstName();
	}

	public void visit(BoolConst constVal) {
		this.constKind = boolType;
		this.constVal = constVal.getB1() == Boolean.TRUE ? 1 : 0;
		constVal.struct = boolType;
	}

	public void visit(CharConst constVal) {
		this.constKind = Tab.charType;
		this.constVal = Integer.valueOf((int) constVal.getC1().charValue());
		constVal.struct = Tab.charType;
	}

	public void visit(NumConst constVal) {
		this.constKind = Tab.intType;
		this.constVal = constVal.getN1();
		constVal.struct = Tab.intType;
	}

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			type.struct = Tab.noType;
		} else {
			if (Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}
	}

	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName()
					+ " nema return iskaz!", null);
		}

		if (currentMethod.getName().equals("main") && methodDecl.getFormPars() instanceof NoFormParam) {
			mainFound = true;
		}

		localVarDeclCount += Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();

		returnFound = false;
		currentMethod = null;
	}

	public void visit(MethodVoidName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), Tab.noType);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}

	public void visit(MethodNonVoidName methodTypeName) {
		currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethName(), methodTypeName.getType().struct);
		methodTypeName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodTypeName.getMethName(), methodTypeName);
	}

	public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error(
					"Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ",
					null);
	}

	public void visit(MulAssignment ass) {
		Struct elemType = ass.getDesignator().obj.getType().getElemType();
		int type = ass.getDesignator().obj.getType().getKind();
		if (type != Struct.Array) {
			report_error("Promenljiva " + ass.getDesignator().obj.getName() + " mora biti tipa niza", ass);
		}

		for (int i = 0; i < assignNames.size(); i++) {
			if (assignTypes.get(i) != null && elemType.assignableTo(assignTypes.get(i))) {
				report_error("Vrednost designatora " + assignNames.get(i) + " nije kompatibilna pri dodeli", ass);
			}
		}
	}

	public void visit(AssignSingle ass) {
		assignNames = new ArrayList<>();
		assignTypes = new ArrayList<>();
		AssignDes des = ass.getAssignDes();
		if (des instanceof NoDes) {
			assignNames.add(null);
			assignTypes.add(null);
		} else if (des instanceof AssignDest) {
			int kind = ((AssignDest) des).getDesignator().obj.getKind();
			if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
				report_error("Designator mora biti promenljiva, element niza ili polje", ass);
			}
			assignNames.add(((AssignDest) des).getDesignator().obj.getName());
			assignTypes.add(((AssignDest) des).getDesignator().obj.getType());
		}
	}

	public void visit(AssignMul ass) {
		AssignDes des = ass.getAssignDes();
		if (des instanceof NoDes) {
			assignNames.add(null);
			assignTypes.add(null);
		} else if (des instanceof AssignDest) {
			int kind = ((AssignDest) des).getDesignator().obj.getKind();
			if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
				report_error("Designator mora biti promenljiva, element niza ili polje", ass);
			}
			assignNames.add(((AssignDest) des).getDesignator().obj.getName());
			assignTypes.add(((AssignDest) des).getDesignator().obj.getType());
		}
	}

	public void visit(Print printStmt) {
		Struct str = printStmt.getPrintExpr().struct;
		if (str != boolType && str != Tab.charType && str != Tab.intType) {
			report_error("Expression mora biti primitivnog tipa!", printStmt);
		}
	}

	public void visit(PrintE expr) {
		expr.struct = expr.getExpr().struct;
	}

	public void visit(PrintNum expr) {
		expr.struct = expr.getExpr().struct;
	}

	public void visit(Read readStmt) {
		Obj des = readStmt.getDesignator().obj;
		int kind = des.getKind();
		if (kind != Obj.Var && kind != Obj.Elem && kind != Obj.Fld) {
			report_error("Designator mora biti promenljiva, element niza ili polje!", readStmt);
		} else if (des.getType() != boolType && des.getType() != Tab.charType && des.getType() != Tab.intType) {
			report_error("Designator mora biti primitivnog tipa!", readStmt);
		}
	}

	public void visit(ReturnExpr returnExpr) {
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Greska na liniji " + returnExpr.getLine() + " : "
					+ "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije "
					+ currentMethod.getName(), null);
		}
	}

	public void visit(ProcCall procCall) {
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
			// RESULT = func.getType();
		} else {
			report_error("Greska na liniji " + procCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			// RESULT = Tab.noType;
		}
	}

	public void visit(AddExpr addExpr) {
		Struct te = addExpr.getExpr().struct;
		Struct t = addExpr.getTerm().struct;
		if (te.equals(t) && te == Tab.intType)
			addExpr.struct = te;
		else {
			report_error("Greska na liniji " + addExpr.getLine()
					+ " : nekompatibilni tipovi u izrazu za aditivnu operaciju.", null);
			addExpr.struct = Tab.noType;
		}
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(NegTermExpr term) {
		if (term.getTerm().struct != Tab.intType) {
			report_error("Greska na liniji " + term.getLine() + " : nekompatibilni tipovi u izrazu za negaciju.", null);
			term.struct = Tab.noType;
		} else {
			term.struct = Tab.intType;
		}
	}

	public void visit(MulTerm term) {

		Struct mulTermStr = term.getTerm().struct;
		Struct factorStr = term.getFactor().struct;
		if (mulTermStr.equals(factorStr) && mulTermStr == Tab.intType) {
			term.struct = mulTermStr;
		} else {
			report_error("Greska na liniji " + term.getLine()
					+ " : nekompatibilni tipovi u izrazu za multiplikativnu operaciju.", null);
			term.struct = Tab.noType;
		}
	}

	public void visit(TermSingle term) {
		term.struct = term.getFactor().struct;
	}

	public void visit(Const cnst) {
		cnst.struct = cnst.getConstVal().struct;
	}

	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}

	public void visit(ArgCall arg) {
		arg.struct = arg.getExpr().struct;
	}

	public void visit(NewArray arr) {
		if (arr.getExpr().struct != Tab.intType) {
			report_error("Vrednost velicine niza mora biti tipa int!", arr);
			arr.struct = Tab.noType;
		} else {
			arr.struct = new Struct(Struct.Array, arr.getType().struct);
		}
	}

	public void visit(FuncCall funcCall) {
		Obj func = funcCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) {
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} else {
			report_error("Greska na liniji " + funcCall.getLine() + " : ime " + func.getName() + " nije funkcija!",
					null);
			funcCall.struct = Tab.noType;
		}

	}

	public void visit(Desig designator) {
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getName()
					+ " nije deklarisano! ", null);
		} else {
			report_info("Pronadjeno " + designator.getName() + " " + obj.toString(), designator);
		}
		designator.obj = obj;
	}

	public void visit(ArrayDesignator designator) {
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) {
			report_error("Greska na liniji " + designator.getLine() + " : ime " + designator.getName()
					+ " nije deklarisano! ", null);
		} else {
			report_info("Pronadjeno " + designator.getName() + " " + obj.toString(), designator);
		}
		designator.obj = obj;
	}

	public void visit(Incr incr) {
		if (incr.getDesignator().obj.getType().getKind() != Struct.Int) {
			report_error("Greska na liniji " + incr.getLine() + " : " + incr.getDesignator().obj.getName()
					+ " nije tipa kompatibilnog za inkrementiranje! ", null);
		}
	}

	public void visit(Decr decr) {
		if (decr.getDesignator().obj.getType().getKind() != Struct.Int) {
			report_error("Greska na liniji " + decr.getLine() + " : " + decr.getDesignator().obj.getName()
					+ " nije tipa kompatibilnog za dekrementiranje! ", null);
		}
	}

	public boolean passed() {
		return !errorDetected;
	}

}
