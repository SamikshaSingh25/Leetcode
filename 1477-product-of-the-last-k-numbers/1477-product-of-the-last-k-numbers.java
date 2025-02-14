class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
        // return null;
    }
    
    public int getProduct(int k) {
        int n=list.size(), product=1,i=k;
        while(i>0){
            product*=list.get(n-i);
            i--;
        }
        return product;

    }

}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */