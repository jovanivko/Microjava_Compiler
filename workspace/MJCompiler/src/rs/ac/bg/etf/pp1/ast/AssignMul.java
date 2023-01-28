// generated with ast extension for cup
// version 0.8
// 28/0/2023 7:16:51


package rs.ac.bg.etf.pp1.ast;

public class AssignMul extends AssignList {

    private AssignList AssignList;
    private AssignDes AssignDes;

    public AssignMul (AssignList AssignList, AssignDes AssignDes) {
        this.AssignList=AssignList;
        if(AssignList!=null) AssignList.setParent(this);
        this.AssignDes=AssignDes;
        if(AssignDes!=null) AssignDes.setParent(this);
    }

    public AssignList getAssignList() {
        return AssignList;
    }

    public void setAssignList(AssignList AssignList) {
        this.AssignList=AssignList;
    }

    public AssignDes getAssignDes() {
        return AssignDes;
    }

    public void setAssignDes(AssignDes AssignDes) {
        this.AssignDes=AssignDes;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignList!=null) AssignList.accept(visitor);
        if(AssignDes!=null) AssignDes.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignList!=null) AssignList.traverseTopDown(visitor);
        if(AssignDes!=null) AssignDes.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignList!=null) AssignList.traverseBottomUp(visitor);
        if(AssignDes!=null) AssignDes.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AssignMul(\n");

        if(AssignList!=null)
            buffer.append(AssignList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AssignDes!=null)
            buffer.append(AssignDes.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AssignMul]");
        return buffer.toString();
    }
}
