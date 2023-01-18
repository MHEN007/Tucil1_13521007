class Main {
    public static void main(String[] args){
        Input in = new Input();
        
        in.inputAuto();

        System.out.println(in.k1);
        System.out.println(in.k2);
        System.out.println(in.k3);
        System.out.println(in.k4);

        TwentyFour tf = new TwentyFour(in.k1, in.k2, in.k3, in.k4);

        tf.findTwentyFour();
    }
}
