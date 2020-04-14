public class DynamicArray{
    
    int array[];
    int n;
    int capacity;
    // constructor
    public DynamicArray(){
        array=new int[1]; //1 elemanlı boş bir array
        n=0;  //eleman sayısı
        capacity=1; //toplam kapasite
    }
    //Sona eleman ekleme işleminde average case = O(1) , worst case = O(n)
    //Amortized cost durumunda en az bir kere worst case oldugu için complexity = O(n)
    public void append(int data){
        //eleman sayısının dizinin boyutuna eşit olup olmadığı kontrol edilir
        if(n==capacity){
            int new_array[] = new int[capacity * 2]; //kapasite 2 katına cıkarılır
            for(int i = 0; i < capacity; i++){
                new_array[i] = array[i]; //n'e kadar olan elemanlar yeni diziye aktarılır
            }
            //yeni değerler değişkenlere atanır
            array=new_array;
            capacity=capacity*2;
        }
        //Eger kapasite yeterliyse direkt atama yapılır
        array[n]=data; 
        n++; //eleman sayısı arttırma
    }
    //Sondan eleman silme işleminde average case= O(n), worst case = O(n)
    //complexity = O(n)
    public void remove(){
        //Dizide eleman varsa sondan silme işlemi yapılır
        if (n > 0) {
            array[n - 1] = 0;
            n--;
        }
    }
    //Append işlemindeki kapasite arttırma resize fonk ile de yapılabilir
    //complexity = O(n)
    public void resize(int new_capacity){
        int temp[] = new int[new_capacity];
        for(int i = 0; i < capacity; i++){
            temp[i] = array[i];
        }
        array=temp;
        capacity=new_capacity;
    }
    
	public static void main(String[] args) {
		DynamicArray array = new DynamicArray();
         
        System.out.println("Array eleman sayısı:" + array.n + ", Array kapasite: " + array.capacity);
         
        array.append(2);
        array.append(5);
        array.append(17);
        array.append(26);
        array.append(48);
        System.out.println("Array eleman sayısı:" + array.n + ", Array kapasite: " + array.capacity);

        array.remove();
        array.remove();
        array.remove();
        array.remove();
        array.remove();
        System.out.println("Array eleman sayısı:" + array.n + ", Array kapasite: " + array.capacity);
        
        //Gerekli oldugunda kullanılacaktır
        array.resize(20);
        array.resize(30);
        array.resize(55);
        array.resize(60);
        array.resize(90);
        System.out.println("Array eleman sayısı:" + array.n + ", Array kapasite: " + array.capacity);
	}
}
