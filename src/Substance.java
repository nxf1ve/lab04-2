public class Substance {
    private String name;
    private double density;
    private String chemicalSymbol;

    public Substance(String name, double density, String chemicalSymbol) {
        this.name = name;
        this.density = density;
        this.chemicalSymbol = chemicalSymbol;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public String getChemicalSymbol() {
        return chemicalSymbol;
    }
}
