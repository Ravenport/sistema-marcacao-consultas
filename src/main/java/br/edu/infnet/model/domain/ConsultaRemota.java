package br.edu.infnet.model.domain;

public class ConsultaRemota extends Consulta{
    private String link;

    @Override
    public String toString() {
        return super.toString() + ", Link= " + link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
