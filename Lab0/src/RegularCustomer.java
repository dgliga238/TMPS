class RegularCustomer implements IPay{

    private SellService sellService;

    public RegularCustomer(SellService sellService){
        this.sellService = sellService;
    }
    @Override
    public boolean buyToy(Toy toy) {
        return sellService.buyToy(toy);
    }
}
