package Tester.intermediateCertification.toyStore.model;

public class Toy {
    String id;
    String name;
    Integer count;
    Integer dropRate;

    /** Конструктор игрушки
     * @param id идентификатор игрушки, целое, положительное
     * @param name название игрушки, текст
     * @param count количество игрушек, целое, положительное
     * @param dropRate частота выпадения игрушки в %, целое в диапазоне [0, 100]
     */
    public Toy(String id, String name, Integer count, Integer dropRate) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.dropRate = dropRate;
    }

    public Toy(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    /** Задать id игрушки
     * @param id id игрушки
     */
    public void setId(String id) {
        this.id = id;
    }

    /** Задать название игрушки
     * @param name название игрушки
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Задать количество игрушек
     * @param count количество игрушек
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /** Задать частоту выпадения игрушки.
    * @param dropRate частота выпадения игрушки в % в диапазоне [0, 100].
    */
    public void setDropRate(Integer dropRate) {
        this.dropRate = dropRate;
    }

    /** Уменьшить количество игрушек на 1 */
    public void decCount() {
        this.count -= 1;
    }

    /** Уменьшить количество игрушек
     * @param decCount число на которое надо уменьшить количество игрушек
     */
    public void decCount(Integer decCount) {
        this.count -= decCount;
    }

    /** Увеличить количество игрушек на 1 */
    public void incCount() {
        this.count += 1;
    }

    /** Увеличить количество игрушек
     * @param incCount число на которое надо увеличить количество игрушек
     */
    public void incCount(Integer incCount) {
        this.count += incCount;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCount() {
        return this.count;
    }

    public Integer getDropRate() {
        return this.dropRate;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, название: %s, количество: %s, частота выпадения: %s.\n", this.id, this.name, this.count,this.dropRate);
    }    
}
