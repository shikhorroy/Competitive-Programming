<h3>How to's...</h3>

**<u>CFR - 478</u>**

01. sort string alphabetically.
    
    Sort characters in a string in java. e.g. `String s = "edcba"  ->  "abcde"`
        
            String original = "edcba";
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            System.out.println(sorted);
    
02. Copy an array into another array or into a collection.

**<u>Answer</u>:**
    
   - Using `System.arraycopy()` (shallow copy)    
               
            int[] src  = new int[]{1,2,3,4,5};
            int[] dest = new int[5];
            System.arraycopy( src, 0, dest, 0, src.length );
 
   - Using `Arrays.copyOf()` (shallow copy)
 
            int[] a = new int[5]{1,2,3,4,5};
            int[] b = Arrays.copyOf(a, a.length);
        
   - Using `Arrays.copyOfRange()`
    
            public static <T> T[] copyOfRange(T[] original, int from, int to)
   
   - Using `Object.clone()`
       
            int[] a = new int[]{1,2,3,4,5};
            int[] b = a.clone();
