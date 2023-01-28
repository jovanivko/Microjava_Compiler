// generated with ast extension for cup
// version 0.8
// 28/0/2023 7:16:51


package rs.ac.bg.etf.pp1.ast;

public class ClassMethods extends ClassMethodList {

    private MemberDeclList MemberDeclList;

    public ClassMethods (MemberDeclList MemberDeclList) {
        this.MemberDeclList=MemberDeclList;
        if(MemberDeclList!=null) MemberDeclList.setParent(this);
    }

    public MemberDeclList getMemberDeclList() {
        return MemberDeclList;
    }

    public void setMemberDeclList(MemberDeclList MemberDeclList) {
        this.MemberDeclList=MemberDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MemberDeclList!=null) MemberDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MemberDeclList!=null) MemberDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MemberDeclList!=null) MemberDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassMethods(\n");

        if(MemberDeclList!=null)
            buffer.append(MemberDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassMethods]");
        return buffer.toString();
    }
}
