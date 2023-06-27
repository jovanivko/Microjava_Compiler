// generated with ast extension for cup
// version 0.8
// 27/5/2023 21:32:19


package rs.ac.bg.etf.pp1.ast;

public class GlobalConst extends ConstNameList {

    private ConstName ConstName;

    public GlobalConst (ConstName ConstName) {
        this.ConstName=ConstName;
        if(ConstName!=null) ConstName.setParent(this);
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
        if(ConstName!=null) ConstName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstName!=null) ConstName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstName!=null) ConstName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalConst(\n");

        if(ConstName!=null)
            buffer.append(ConstName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalConst]");
        return buffer.toString();
    }
}
