import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] array = null;
        Random random = new Random(); // Creamos una instancia de Random
        
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Generar arreglos aleatorios con diferentes tamaños");
            System.out.println("2. Ordenar por los 3 metodos ");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Ingrese el tamaño del arreglo: ");
                    int tamano = scanner.nextInt();
                    System.out.println("Ingrese la semilla para el generador de números aleatorios: ");
                    long semilla = scanner.nextLong();
                    random.setSeed(semilla); // Configuramos la semilla
                    array = generateRandomArray(tamano, random); // Pasamos el objeto Random como argumento
                    System.out.println("Arreglo aleatorio generado: " + Arrays.toString(array));
                    break;
                case 2:
                    if(array == null){
                        System.out.println("Debe generar un arreglo primero");
                        break;
                    }
                    testSortingAlgorithms(array);
                    break;
                case 3:
                   System.out.println("Saliendo del programa");
                   return;
                default:
                    System.out.println("Opción invalida. Seleccione de nuevo."); 
            }
        }
    }

    public static int[] generateRandomArray(int tamano, Random random) { // Pasamos el objeto Random como argumento
        int[] array = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            array[i] = random.nextInt(100); // Rango de valores aleatorios de 0 a 99
        }
        return array;
    }

    public static void testSortingAlgorithms(int[] array) {
        int[] clonedArray = array.clone();
        
        System.out.println("Método Burbuja con Ajustes:");
        measureSortingAlgorithm(clonedArray.clone(), "bubbleSort");

        clonedArray = array.clone();
        System.out.println("Método Selección:");
        measureSortingAlgorithm(clonedArray.clone(), "selectionSort");
        
        clonedArray = array.clone();
        System.out.println("Método Inserción:");
        measureSortingAlgorithm(clonedArray.clone(), "insertionSort");
    }

    public static void measureSortingAlgorithm(int[] array, String methodName) {
        long startTime = System.currentTimeMillis();
        
        switch (methodName) {
            case "bubbleSort":
                bubbleSort(array);
                break;
            case "selectionSort":
                selectionSort(array);
                break;
            case "insertionSort":
                insertionSort(array);
                break;
            default:
                System.out.println("Método de ordenamiento no válido");
                return;
        }
        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        
        System.out.println("Con " + array.length + " valores el tiempo es de " + elapsedTime + " milisegundos.");
        System.out.println("Lista ordenada: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;

                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

