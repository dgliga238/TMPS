class PermanentCustomer implements IPay, IGetDiscount{
 private SellService sellService;

    public PermanentCustomer(SellService sellService) {
        this.sellService = sellService;
    }

    @Override
    public boolean getDiscount(Toy toy) {
        return sellService.getDiscount(toy);
    }

    @Override
    public boolean buyToy(Toy toy) {
        return sellService.buyToy(toy);
    }
}
