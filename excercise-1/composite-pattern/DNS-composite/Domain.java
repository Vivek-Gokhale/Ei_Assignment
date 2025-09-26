// 3. Composite (Domain / Subdomain)
import java.util.ArrayList;
import java.util.List;

class Domain implements DomainComponent {
    private String name;
    private List<DomainComponent> children = new ArrayList<>();

    public Domain(String name) {
        this.name = name;
    }

    // adding domain compoenet to collection
    public void add(DomainComponent component) {
        children.add(component);
    }

    // showing domain to particular level
    public void show(int level) {
        System.out.println("  ".repeat(level) + "+ " + name);
        for (DomainComponent child : children) {
            child.show(level + 1);
        }
    }
}