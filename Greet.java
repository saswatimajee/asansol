class Greet {
    int i; boolean b; String s;
    Greet(){
        i = 10; b = true; s = "Vulk";
    }
    Greet(int x){
        i=x;
    }
    Greet(String y, boolean z){
        s=y; b=z;
    }  
}
class Mario{
    
    public static void main(String[] args) {
        Greet A = new Greet();
        Greet B = new Greet(x:10);
        Greet B = new Greet(x:10);
        Greet C = new Greet(y:"Pekka", z:false);
        System.out.println( A.i + " " + A.b + " " + A.s);
        System.out.println( B.i );
        System.out.println( C.b + " " + C.s);
    }
}

