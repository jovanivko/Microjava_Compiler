// generated with ast extension for cup
// version 0.8
// 7/1/2023 22:6:28


package rs.ac.bg.etf.pp1.ast;

public class MulAssignment extends DesignatorStatement {

    private AssignList AssignList;
    private Assign Assign;
    private Designator Designator;

    public MulAssignment (AssignList AssignList, Assign Assign, Designator Designator) {
        this.AssignList=AssignList;
        if(AssignList!=null) AssignList.setParent(this);
        this.Assign=Assign;
        if(Assign!=null) Assign.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public AssignList getAssignList() {
        return AssignList;
    }

    public void setAssignList(AssignList AssignList) {
        this.AssignList=AssignList;
    }

    public Assign getAssign() {
        return Assign;
    }

    public void setAssign(Assign Assign) {
        this.Assign=Assign;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignList!=null) AssignList.accept(visitor);
        if(Assign!=null) Assign.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignList!=null) AssignList.traverseTopDown(visitor);
        if(Assign!=null) Assign.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignList!=null) AssignList.traverseBottomUp(visitor);
        if(Assign!=null) Assign.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulAssignment(\n");

        if(AssignList!=null)
            buffer.append(AssignList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Assign!=null)
            buffer.append(Assign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulAssignment]");
        return buffer.toString();
    }
}
