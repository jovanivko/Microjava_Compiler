// generated with ast extension for cup
// version 0.8
// 7/1/2023 22:6:28


package rs.ac.bg.etf.pp1.ast;

public class ErrClassVarDecl extends ClassBody {

    private VarDeclList VarDeclList;
    private ClassMethodList ClassMethodList;

    public ErrClassVarDecl (VarDeclList VarDeclList, ClassMethodList ClassMethodList) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ClassMethodList=ClassMethodList;
        if(ClassMethodList!=null) ClassMethodList.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ClassMethodList getClassMethodList() {
        return ClassMethodList;
    }

    public void setClassMethodList(ClassMethodList ClassMethodList) {
        this.ClassMethodList=ClassMethodList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ClassMethodList!=null) ClassMethodList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ClassMethodList!=null) ClassMethodList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ClassMethodList!=null) ClassMethodList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrClassVarDecl(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassMethodList!=null)
            buffer.append(ClassMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrClassVarDecl]");
        return buffer.toString();
    }
}
