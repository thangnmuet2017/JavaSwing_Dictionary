package lab04;

public class Lab04 {
    // tim lon nhat
    static int timLonHon(int a, int b) {
        return (a > b)?a:b;
    }
    // tim nho nhat trong mang
    static int timNhoNhat(int[] arr, int numOfElement) {
        int min_value = arr[0];
        for (int i = 1; i < numOfElement; i++) {
            if (arr[i] > min_value) {
                min_value = arr[i];
            }
        }
        return min_value;
    }
    static String BMI(double height, double weight) {
        double BMI_value = weight/(height*height);
        if (BMI_value < 18.5) {
            return "Thieu can";
        }
        else if (BMI_value >= 18.5 && BMI_value < 23) {
            return "Binh thuong";
        }
        else if (BMI_value >= 23 && BMI_value <= 24.99) {
            return "Thua can";
        }
        else {
            return "Beo phi";
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
