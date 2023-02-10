// generated with ast extension for cup
// version 0.8
// 7/1/2023 22:6:28


package rs.ac.bg.etf.pp1.ast;

public class ErrAssignment extends DesignatorStatement {

    private Designator Designator;
    private Assign Assign;

    public ErrAssignment (Designator Designator, Assign Assign) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Assign=Assign;
        if(Assign!=null) Assign.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Assign getAssign() {
        return Assign;
    }

    public void setAssign(Assign Assign) {
        this.Assign=Assign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(Assign!=null) Assign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Assign!=null) Assign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Assign!=null) Assign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrAssignment(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Assign!=null)
            buffer.append(Assign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ErrAssignment]");
        return buffer.toString();
    }
}
