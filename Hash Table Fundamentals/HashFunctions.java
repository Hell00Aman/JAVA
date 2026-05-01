public class HashFunctions {

    // ========== INTEGER HASH FUNCTION ==========
    // Simple modulo-based hashing
    public static int hashInteger(int key, int tableSize) {
        return Math.abs(key) % tableSize;
    }

    // ========== STRING HASH FUNCTION ==========
    // Polynomial Rolling Hash (efficient & widely used)
    public static int hashString(String key, int tableSize) {
        int hash = 0;
        int prime = 31; // good prime number

        for (int i = 0; i < key.length(); i++) {
            hash = hash * prime + key.charAt(i);
        }

        return Math.abs(hash) % tableSize;
    }

    // ========== POOR HASH FUNCTION ==========
    // Uses only first character → high collisions
    public static int poorHash(String key, int tableSize) {
        return key.charAt(0) % tableSize;
    }

    // ========== JAVA BUILT-IN HASH ==========
    public static void demonstrateJavaHash() {
        String[] emails = {
            "user@gmail.com",
            "admin@company.com",
            "support@service.org"
        };

        System.out.println("\nJava's String hashCode():");

        for (String email : emails) {
            System.out.println(email + " -> " + email.hashCode());
        }
    }

    public static void main(String[] args) {

        int tableSize = 10;

        String[] usernames = {"alice", "bob", "charlie", "david", "eve"};

        // Good hash function
        System.out.println("Custom String Hash (Good Distribution):");
        for (String name : usernames) {
            int hash = hashString(name, tableSize);
            System.out.println(name + " -> bucket " + hash);
        }

        // Poor hash function
        System.out.println("\nPoor Hash Function (High Collisions):");
        for (String name : usernames) {
            int hash = poorHash(name, tableSize);
            System.out.println(name + " -> bucket " + hash + " (COLLISION LIKELY)");
        }

        // Java built-in
        demonstrateJavaHash();
    }
}
