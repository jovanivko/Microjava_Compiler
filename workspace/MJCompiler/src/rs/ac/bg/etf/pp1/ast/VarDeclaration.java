// generated with ast extension for cup
// version 0.8
// 27/5/2023 21:32:19


package rs.ac.bg.etf.pp1.ast;

public class VarDeclaration extends VarDecl {

    private Type Type;
    private VarNameDecl VarNameDecl;

    public VarDeclaration (Type Type, VarNameDecl VarNameDecl) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarNameDecl=VarNameDecl;
        if(VarNameDecl!=null) VarNameDecl.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarNameDecl getVarNameDecl() {
        return VarNameDecl;
    }

    public void setVarNameDecl(VarNameDecl VarNameDecl) {
        this.VarNameDecl=VarNameDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarNameDecl!=null) VarNameDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarNameDecl!=null) VarNameDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarNameDecl!=null) VarNameDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarNameDecl!=null)
            buffer.append(VarNameDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclaration]");
        return buffer.toString();
    }
}
