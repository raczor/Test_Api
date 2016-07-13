package hello;

import java.util.List;

/**
 * Created by OscarBarrios on 7/13/2016.
 */
public class RequestWrapper {
    private NameDto name;
    private List<NameDto> names;

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }

    public List<NameDto> getNames() {
        return names;
    }

    public void setNames(List<NameDto> names) {
        this.names = names;
    }
}
