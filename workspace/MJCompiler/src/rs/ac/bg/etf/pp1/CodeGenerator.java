package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.AddExpr;
import rs.ac.bg.etf.pp1.ast.AddsOp;
import rs.ac.bg.etf.pp1.ast.ArrayDesignator;
import rs.ac.bg.etf.pp1.ast.Assignment;
import rs.ac.bg.etf.pp1.ast.BoolConst;
import rs.ac.bg.etf.pp1.ast.CharConst;
import rs.ac.bg.etf.pp1.ast.Decr;
import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DivOp;
import rs.ac.bg.etf.pp1.ast.FindAny;
import rs.ac.bg.etf.pp1.ast.Incr;
import rs.ac.bg.etf.pp1.ast.MethodDecl;
import rs.ac.bg.etf.pp1.ast.MethodVoidName;
import rs.ac.bg.etf.pp1.ast.MulTerm;
import rs.ac.bg.etf.pp1.ast.MulsOp;
import rs.ac.bg.etf.pp1.ast.NegTermExpr;
import rs.ac.bg.etf.pp1.ast.NewArray;
import rs.ac.bg.etf.pp1.ast.NumConst;
import rs.ac.bg.etf.pp1.ast.Print;
import rs.ac.bg.etf.pp1.ast.PrintNum;
import rs.ac.bg.etf.pp1.ast.Read;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.ast.Var;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;

	public int getMainPc() {
		return mainPc;
	}

	public void visit(Print printStmt) {
		int w = 0;
		if (printStmt.getPrintExpr() instanceof PrintNum) {
			w = ((PrintNum) printStmt.getPrintExpr()).getN2().intValue();
		}

		if (printStmt.getPrintExpr().struct == Tab.intType
				|| printStmt.getPrintExpr().struct == SemanticAnalyzer.boolType) {
			if (w == 0) {
				w = 5;
			}
			Code.loadConst(w);
			Code.put(Code.print);
		} else if (printStmt.getPrintExpr().struct == Tab.charType) {
			if (w == 0) {
				w = 2;
			}
			Code.loadConst(w);
			Code.put(Code.bprint);
		}
	}

	public void visit(NumConst num) {
		Code.loadConst(num.getN1());
	}

	public void visit(CharConst chr) {
		Code.loadConst((int) chr.getC1().charValue());
	}

	public void visit(BoolConst bool) {
		Code.loadConst(bool.getB1() ? 1 : 0);
	}

	public void visit(Read read) {
		if (read.getDesignator().obj.getType().equals(Tab.charType))
			Code.put(Code.bread);
		else
			Code.put(Code.read);

		Code.store(read.getDesignator().obj);
	}

	public void visit(MethodVoidName methodTypeName) {

		if ("main".equalsIgnoreCase(methodTypeName.getMethName())) {
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();

		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);

		FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);

		// Generate the entry
		Code.put(Code.enter);
		Code.put(fpCnt.getCount());
		Code.put(fpCnt.getCount() + varCnt.getCount());

	}

	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	public void visit(Assignment assignment) {
		Code.store(assignment.getDesignator().obj);
	}

	public void visit(Designator designator) {
		SyntaxNode parent = designator.getParent();

		if (Assignment.class != parent.getClass()) {
			Code.load(designator.obj);
		}
	}

	public void visit(ArrayDesignator des) {
		Code.load(des.getDesignator().obj);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
	}

	public void visit(AddExpr addExpr) {
		if (addExpr.getAddOp() instanceof AddsOp)
			Code.put(Code.add);
		else
			Code.put(Code.sub);
	}

	public void visit(MulTerm mul) {
		if (mul.getMulOp() instanceof MulsOp)
			Code.put(Code.mul);
		else if (mul.getMulOp() instanceof DivOp)
			Code.put(Code.div);
		else
			Code.put(Code.rem);
	}

	public void visit(Incr inc) {
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}

	public void visit(Decr dec) {
		Code.load(dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}

	public void visit(NegTermExpr neg) {
		Code.put(Code.neg);
	}

	public void visit(Var var) {
		Code.load(var.getDesignator().obj);
	}

	public void visit(NewArray newa) {
		Code.put(Code.newarray);
		if (newa.getType().struct.equals(Tab.charType))
			Code.put(0);
		else
			Code.put(1);
	}

	public void visit(FindAny find) {
		Code.put(Code.enter);
		Code.put(0);
		Code.put(3);
		Code.put(Code.store_n);
		Code.load(find.getDesignator1().obj);
		Code.put(Code.store_1);
		// na n registru se nalazi vrednost koju pretrazujemo, na registru 1 adresa
		// niza, a na registru 2 tekuci indeks
		// pocetak petlje dok ne prodjemo ceo niz
		int loopTop = Code.pc;
		Code.put(Code.load_1);
		Code.put(Code.arraylength);
		Code.put(Code.load_2);
		Code.putFalseJump(Code.gt, 0);
		int frwadr = Code.pc - 2;
		Code.put(Code.load_1);
		Code.put(Code.load_2);
		if (find.getDesignator1().obj.getType() == Tab.charType) {
			Code.put(Code.baload);
		} else {
			Code.put(Code.aload);
		}
		Code.put(Code.load_n);
		Code.putFalseJump(Code.ne, 0);
		int trueadr = Code.pc - 2;
		Code.put(Code.inc);
		Code.put(2);
		Code.put(1);
		Code.putJump(loopTop);
		Code.fixup(trueadr);
		Code.loadConst(1);
		Code.putJump(0);
		int btmadr = Code.pc - 2;
		Code.fixup(frwadr);
		Code.loadConst(0);
		Code.fixup(btmadr);
		int bottom = Code.pc;
		Code.put(Code.exit);
		Code.store(find.getDesignator().obj);
	}
}
