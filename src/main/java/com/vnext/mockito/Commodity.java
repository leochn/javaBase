/**
 * 
 */
package com.vnext.mockito;

/**
 * @author leo
 * @since 2018-02-06 13:50:42
 */
public class Commodity {

    private String id;
    
    private String name;
    
    private int type;

    public Commodity() {
        // nothing
    }
    
    public Commodity(String id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
