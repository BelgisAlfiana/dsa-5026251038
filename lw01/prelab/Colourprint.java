class Colourprint extends PrintJob {

    public Colourprint(String id, int pages) {
        super(id,pages);
    }

    @Override 
    public int calculateCharge() {
        int charge; 
        if (getPages() <= 10) {
           charge = getPages() * 1500;
        }
        else {
            charge = (10 * 1500) + ((getPages()  - 10) * 1000);
        }
        return charge + 2000;  
    }

    public String label() {
        return "Colour";
    }

}
