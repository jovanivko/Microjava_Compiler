// generated with ast extension for cup
// version 0.8
// 27/5/2023 3:2:23


package rs.ac.bg.etf.pp1.ast;

public class GlobalConstDeclList extends ConstNameList {

    private ConstNameList ConstNameList;
    private ConstName ConstName;

    public GlobalConstDeclList (ConstNameList ConstNameList, ConstName ConstName) {
        this.ConstNameList=ConstNameList;
        if(ConstNameList!=null) ConstNameList.setParent(this);
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
    }

    public ConstNameList getConstNameList() {
        return ConstNameList;
    }

    public void setConstNameList(ConstNameList ConstNameList) {
        this.ConstNameList=ConstNameList;
    }

    public ConstName getConstName() {
        return ConstName;
    }

    public void setConstName(ConstName ConstName) {
        this.ConstName=ConstName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstNameList!=null) ConstNameList.accept(visitor);
        if(ConstName!=null) ConstName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstNameList!=null) ConstNameList.traverseTopDown(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstNameList!=null) ConstNameList.traverseBottomUp(visitor);
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalConstDeclList(\n");

        if(ConstNameList!=null)
            buffer.append(ConstNameList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstName!=null)
            buffer.append(ConstName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalConstDeclList]");
        return buffer.toString();
    }
}
