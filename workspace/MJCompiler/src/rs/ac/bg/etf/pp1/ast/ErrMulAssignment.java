// generated with ast extension for cup
// version 0.8
// 28/0/2023 18:33:52


package rs.ac.bg.etf.pp1.ast;

public class ErrMulAssignment extends DesignatorStatement {

    private AssignList AssignList;

    public ErrMulAssignment (AssignList AssignList) {
        this.AssignList=AssignList;
        if(AssignList!=null) AssignList.setParent(this);
    }

    public AssignList getAssignList() {
        return AssignList;
    }

    public void setAssignList(AssignList AssignList) {
        this.AssignList=AssignList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignList!=null) AssignList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignList!=null) AssignList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignList!=null) AssignList.traverseBottomUp(visitor);
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

        buffer.append(tab);
        buffer.append(") [ErrMulAssignment]");
        return buffer.toString();
    }
}
