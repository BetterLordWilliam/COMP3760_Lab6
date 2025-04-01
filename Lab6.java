



public class Lab6 
{
    private static final String MESSAGE = "SW_Recursive(%d,%d) = %d, time is %d ns";

    /**
     * <p>
     * This method calculates and returns SW(m,n) by using the recursive definition
     * above where m & n are the given parameters.
     * </p>
     * 
     * @param m
     * @param n
     * @return
     */
    public long SW_Recursive(int m, int n)
    {
        return (m > 0 && n > 0)
            ? (SW_Recursive(--m, n) + SW_Recursive(m, --n))
            : 1L;
    }

    /**
     * <p>
     * This method calculates and returns the SW(m,n) by using the iterative / dynamic
     * programming definition.
     * </p>
     * 
     * @param m
     * @param n
     * @return
     */
    public long SW_DynamicProg(final int m, final int n)
    {
        long[] results = new long[n];

        results[0] = 1;

        for (int i = 0; i < m; i ++)
        {
            for (int j = 1; j < n; j++)
            {
                results[j] += results[j - 1];
            }
        }

        return results[n - 1];
    }

    /**
     * <p>
     * Call the recursive function with the console formatting once.
     * </p>
     * 
     * @param m
     * @param n
     */
    public void Run(final int m, final int n)
    {
        long start, end, result, resultTime;

        start = System.nanoTime();
        result = SW_Recursive(m, n);
        end = System.nanoTime();

        resultTime = end - start;

        System.out.println(String.format(MESSAGE, m, n, result, resultTime));
    }

    /**
     * <p>
     * Call the dynamic function with the console formatting once.
     * </p>
     * 
     * @param n
     * @param m
     */
    public void RunDynamic(final int n, final int m)
    {
        long start, end, result, resultTime;

        start = System.nanoTime();
        result = SW_DynamicProg(m + 1, n + 1); // Add to make it inclusive
        end = System.nanoTime();

        resultTime = end - start;

        System.out.println(String.format(MESSAGE, m, n, result, resultTime)); 
    }

    /**
     * <p>
     * This method repeatedly calls <pre>SW_Recursive</pre> 
     * </p>
     * 
     * @param m
     * @param n
     */
    public void RunRecursive(int m, int n)
    {
        for (; m <= n; m++) Run(m, m);
    }

    /**
     * <p>
     * This method repeatedly calls <pre>SW_Recursive</pre> 
     * </p>
     * 
     * @param m
     * @param n
     */
    public void RunDynamicProg(int m, int n)
    {
        for (; m <= n; m++) RunDynamic(m, m);
    }
}
