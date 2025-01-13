# Cache-Implementation
Cache Implementation with Multiple Replacement Policies

Για να χρησιμοποιήσετε την προσωρινή μνήμη, δημιουργήστε μια από τις κλάσεις (LRUCache, MRUCache ή LFUCache) με την επιθυμητή χωρητικότητα και πολιτική αντικατάστασης. Για παράδειγμα:
Cache<Integer, String> cache = new LRUCache<>(5);
cache.put(1, "Data1");
cache.put(2, "Data2");
System.out.println(cache.get(1)); // Output: "Data1"

LRUCache<Integer, String> cache = new LRUCache<>(5);
cache.put(1, "Data1");
cache.get(1); // Hit
cache.get(2); // Miss
System.out.println("Hits: " + cache.getHitCount());
System.out.println("Misses: " + cache.getMissCount());

## Περιγραφή
Το **LRUCacheProject** είναι ένα έργο υλοποίησης διαφόρων στρατηγικών αντικατάστασης κρυφής μνήμης (cache replacement policies). Οι στρατηγικές που υποστηρίζονται περιλαμβάνουν:
- Least Recently Used (LRU)
- Least Frequently Used (LFU)
- Most Recently Used (MRU) (προαιρετικό)

Το έργο υποστηρίζει την παρακολούθηση των cache hits/misses και την ανάλυση της απόδοσης για κάθε στρατηγική αντικατάστασης.

## Δομή Έργου
Η δομή του έργου έχει ως εξής:

![image](https://github.com/user-attachments/assets/648dc73b-80df-4360-b903-4b7040869e5e)

## Απαιτήσεις Συστήματος
- **Java Development Kit (JDK):** Έκδοση 17 ή νεότερη
- **Maven:** Έκδοση 3.6.0 ή νεότερη

## Οδηγίες Εγκατάστασης
1. Κλωνοποιήστε το αποθετήριο:
   ```bash
   git clone https://github.com/yourusername/cache-system.git
   cd cache-system

2. Μεταγλωττίστε το έργο με το Maven:
   mvn clean install

3. Εκτελέστε την κύρια εφαρμογή:
   java -cp target/cache-system-1.0-SNAPSHOT.jar com.cache.Main

4. Εκτελέστε τις δοκιμές:
   mvn test

## Στρατηγικές Αντικατάστασης
1. LRU (Least Recently Used): Διατηρεί τα πιο πρόσφατα χρησιμοποιημένα αντικείμενα.

2. LFU (Least Frequently Used): Διατηρεί τα αντικείμενα που χρησιμοποιούνται συχνότερα.

3. MRU (Most Recently Used): Διατηρεί τα πιο πρόσφατα χρησιμοποιημένα αντικείμενα, αλλά αντικαθιστά αυτά που χρησιμοποιήθηκαν τελευταία.

## Παράδειγμα Εκτέλεσης
Κατά την εκτέλεση του προγράμματος με 100.000 λειτουργίες, τα αποτελέσματα είναι:

![image](https://github.com/user-attachments/assets/51772245-ce3c-4d6c-b0c3-cf2a7ae97cab)

## Συνεισφορά
1. Δημιουργήστε ένα fork του αποθετηρίου.
2. Υλοποιήστε τις αλλαγές σας σε ένα νέο branch.
3. Υποβάλετε ένα Pull Request για ανασκόπηση.

## Συμπέρασμα
Το έργο καταδεικνύει την αποτελεσματικότητα της προσωρινής αποθήκευσης με πολλαπλές πολιτικές αντικατάστασης και παρέχει τη βάση για επεκτάσιμες εφαρμογές κρυφής μνήμης σε Java.







