// generated with ast extension for cup
// version 0.8
// 23/7/2023 14:55:24


package rs.ac.bg.etf.pp1.ast;

public class NoVars extends VarDeclList {

    public NoVars () {
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
        buffer.append("NoVars(\n");

        buffer.append(tab);
        buffer.append(") [NoVars]");
        return buffer.toString();
    }
}
