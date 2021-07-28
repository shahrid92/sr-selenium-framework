package test.api.model;

public class ItemCategoriesModel {

    private String display_name;
    private String catid;
    private String image;
    private String no_sub;
    private String is_default_subcat;
    private String block_buyer_platform;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNo_sub() {
        return no_sub;
    }

    public void setNo_sub(String no_sub) {
        this.no_sub = no_sub;
    }

    public String getIs_default_subcat() {
        return is_default_subcat;
    }

    public void setIs_default_subcat(String is_default_subcat) {
        this.is_default_subcat = is_default_subcat;
    }

    public String getBlock_buyer_platform() {
        return block_buyer_platform;
    }

    public void setBlock_buyer_platform(String block_buyer_platform) {
        this.block_buyer_platform = block_buyer_platform;
    }

    @Override
    public String toString() {
        return "ItemCategoriesModel{" +
                "display_name='" + display_name + '\'' +
                ", catid='" + catid + '\'' +
                ", image='" + image + '\'' +
                ", no_sub='" + no_sub + '\'' +
                ", is_default_subcat='" + is_default_subcat + '\'' +
                ", block_buyer_platform='" + block_buyer_platform + '\'' +
                '}';
    }
}
