package org.example;

public class Currency {

    private final String rubel;
    private final String rublya;
    private final String rubley;
    private final String kopeyka;
    private final String kopeek;
    private final String kopeyki;
    private final boolean isRubelFem;
    private final boolean isKopeykaFem;

    public Currency(String rubel, String rublya, String rubley, String kopeyka, String kopeek, String kopeyki, boolean isRubelFemenine, boolean isKopeykaFemenine) {
        this.rubel = rubel;
        this.rublya = rublya;
        this.rubley = rubley;
        this.kopeyka = kopeyka;
        this.kopeek = kopeek;
        this.kopeyki = kopeyki;
        this.isRubelFem = isRubelFemenine;
        this.isKopeykaFem = isKopeykaFemenine;
    }

    public String getRubel() {
        return rubel;
    }

    public String getRublya() {
        return rublya;
    }

    public String getRubley() {
        return rubley;
    }

    public String getKopeyka() {
        return kopeyka;
    }

    public String getKopeek() {
        return kopeek;
    }

    public String getKopeyki() {
        return kopeyki;
    }

    public boolean isRubelFem() {
        return isRubelFem;
    }

    public boolean isKopeykaFem() {
        return isKopeykaFem;
    }
}
