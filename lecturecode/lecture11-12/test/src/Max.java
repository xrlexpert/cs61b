public class Max {
    public static ourComparable max(ourComparable items[])
    {
        ourComparable m=items[0];
        for(int i=1;i<items.length;i++)
        {
            int cmp=m.compareto(items[i]);
            if(cmp==0)
            {
                m=items[i];
            }

        }
        return m;
    }

}
