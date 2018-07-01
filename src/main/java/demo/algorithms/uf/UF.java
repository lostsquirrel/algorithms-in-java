package demo.algorithms.uf;

public interface UF {
    /**
     *
     * add connection between p and q
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * are p and q in the same component?
     *
     * We assume "is connected to" is an equivalence relation:
     ・Reflexive: p is connected to p.
     ・Symmetric: if p is connected to q, then q is connected to p.
     ・Transitive: if p is connected to q and q is connected to r,
     then p is connected to r.
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    int find(int p);
}
