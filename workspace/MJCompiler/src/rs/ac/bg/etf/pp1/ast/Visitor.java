// generated with ast extension for cup
// version 0.8
// 27/5/2023 3:2:23


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Designator Designator);
    public void visit(Factor Factor);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(VarNameList VarNameList);
    public void visit(MulOp MulOp);
    public void visit(ConstNameList ConstNameList);
    public void visit(Expr Expr);
    public void visit(VarName VarName);
    public void visit(ClassDecl ClassDecl);
    public void visit(Decl Decl);
    public void visit(VarNameDecl VarNameDecl);
    public void visit(VarDeclList VarDeclList);
    public void visit(PrintExpr PrintExpr);
    public void visit(VarDecl VarDecl);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(AssExpr AssExpr);
    public void visit(DeclList DeclList);
    public void visit(Statement Statement);
    public void visit(ConstVal ConstVal);
    public void visit(AddOp AddOp);
    public void visit(Term Term);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(RelOp RelOp);
    public void visit(GlobalMethodDecl GlobalMethodDecl);
    public void visit(VarListEntry VarListEntry);
    public void visit(StatementList StatementList);
    public void visit(ModOp ModOp);
    public void visit(DivOp DivOp);
    public void visit(MulsOp MulsOp);
    public void visit(SubOp SubOp);
    public void visit(AddsOp AddsOp);
    public void visit(GrtEOp GrtEOp);
    public void visit(GrtOp GrtOp);
    public void visit(LssEOp LssEOp);
    public void visit(LssOp LssOp);
    public void visit(NeqOp NeqOp);
    public void visit(EqOp EqOp);
    public void visit(MatrixDesignator MatrixDesignator);
    public void visit(ArrayDesignator ArrayDesignator);
    public void visit(Desig Desig);
    public void visit(NewMatrix NewMatrix);
    public void visit(NewArray NewArray);
    public void visit(ArgCall ArgCall);
    public void visit(Var Var);
    public void visit(Const Const);
    public void visit(TermSingle TermSingle);
    public void visit(MulTerm MulTerm);
    public void visit(NegTermExpr NegTermExpr);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(ErrAssignment ErrAssignment);
    public void visit(AssignExpr AssignExpr);
    public void visit(Decr Decr);
    public void visit(Incr Incr);
    public void visit(Assignment Assignment);
    public void visit(PrintNum PrintNum);
    public void visit(PrintE PrintE);
    public void visit(Print Print);
    public void visit(Read Read);
    public void visit(SingleStatement SingleStatement);
    public void visit(NoStmt NoStmt);
    public void visit(Statements Statements);
    public void visit(Type Type);
    public void visit(MethodVoidName MethodVoidName);
    public void visit(MethodNonVoidName MethodNonVoidName);
    public void visit(MethodDecl MethodDecl);
    public void visit(Meth Meth);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(CharConst CharConst);
    public void visit(BoolConst BoolConst);
    public void visit(NumConst NumConst);
    public void visit(ConstName ConstName);
    public void visit(GlobalConst GlobalConst);
    public void visit(GlobalConstDeclList GlobalConstDeclList);
    public void visit(ConstDecl ConstDecl);
    public void visit(VarMatrixName VarMatrixName);
    public void visit(VarArrayName VarArrayName);
    public void visit(VarSingleName VarSingleName);
    public void visit(VarListEntrySingle VarListEntrySingle);
    public void visit(ErrVarDeclList ErrVarDeclList);
    public void visit(VarListEntries VarListEntries);
    public void visit(SingleVar SingleVar);
    public void visit(VarList VarList);
    public void visit(ErrVarDecl ErrVarDecl);
    public void visit(VarNameDecls VarNameDecls);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(NoVars NoVars);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(DeclConst DeclConst);
    public void visit(DeclVar DeclVar);
    public void visit(NoDecl NoDecl);
    public void visit(Declarations Declarations);
    public void visit(NoGlobalMethods NoGlobalMethods);
    public void visit(GlobalMethods GlobalMethods);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
