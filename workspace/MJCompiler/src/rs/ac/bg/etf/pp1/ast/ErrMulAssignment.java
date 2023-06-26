// generated with ast extension for cup
// version 0.8
// 25/5/2023 19:46:42


package rs.ac.bg.etf.pp1.ast;

public class ErrMulAssignment extends DesignatorStatement {

    private AssignList AssignList;
    private Assign Assign;

    public ErrMulAssignment (AssignList AssignList, Assign Assign) {
        this.AssignList=AssignList;
        if(AssignList!=null) AssignList.setParent(this);
        this.Assign=Assign;
        if(Assign!=null) Assign.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignList!=null) AssignList.accept(visitor);
        if(Assign!=null) Assign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignList!=null) AssignList.traverseTopDown(visitor);
        if(Assign!=null) Assign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignList!=null) AssignList.traverseBottomUp(visitor);
        if(Assign!=null) Assign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ErrMulAssignment(\n");

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

        buffer.append(tab);
        buffer.append(") [ErrMulAssignment]");
        return buffer.toString();
    }
}
