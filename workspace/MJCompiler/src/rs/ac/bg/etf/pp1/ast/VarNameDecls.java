// generated with ast extension for cup
// version 0.8
// 27/5/2023 21:32:19


package rs.ac.bg.etf.pp1.ast;

public class VarNameDecls extends VarNameDecl {

    private VarNameList VarNameList;

    public VarNameDecls (VarNameList VarNameList) {
        this.VarNameList=VarNameList;
        if(VarNameList!=null) VarNameList.setParent(this);
    }

    public VarNameList getVarNameList() {
        return VarNameList;
    }

    public void setVarNameList(VarNameList VarNameList) {
        this.VarNameList=VarNameList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarNameList!=null) VarNameList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarNameList!=null) VarNameList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarNameList!=null) VarNameList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarNameDecls(\n");

        if(VarNameList!=null)
            buffer.append(VarNameList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarNameDecls]");
        return buffer.toString();
    }
}
