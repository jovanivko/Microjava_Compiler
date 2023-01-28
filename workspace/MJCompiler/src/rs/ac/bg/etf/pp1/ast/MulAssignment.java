// generated with ast extension for cup
// version 0.8
// 28/0/2023 18:33:52


package rs.ac.bg.etf.pp1.ast;

public class MulAssignment extends DesignatorStatement {

    private AssignList AssignList;
    private Designator Designator;

    public MulAssignment (AssignList AssignList, Designator Designator) {
        this.AssignList=AssignList;
        if(AssignList!=null) AssignList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public AssignList getAssignList() {
        return AssignList;
    }

    public void setAssignList(AssignList AssignList) {
        this.AssignList=AssignList;
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
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignList!=null) AssignList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignList!=null) AssignList.traverseBottomUp(visitor);
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
