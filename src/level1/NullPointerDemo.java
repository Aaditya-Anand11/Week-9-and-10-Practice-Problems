public class NullPointerDemo {
    public static void generateException() {
        String text = null;
        text.length();
    }

    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException exception) {
            System.out.println("Handled NullPointerException: text is null");
        } catch (RuntimeException exception) {
            System.out.println("Handled runtime exception: " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException exception) {
            System.out.println("Generated NullPointerException successfully");
        }

        handleException();
    }
}
