// generated with ast extension for cup
// version 0.8
// 28/0/2023 7:16:51


package rs.ac.bg.etf.pp1.ast;

public class LsEOp extends RelOp {

    public LsEOp () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LsEOp(\n");

        buffer.append(tab);
        buffer.append(") [LsEOp]");
        return buffer.toString();
    }
}
