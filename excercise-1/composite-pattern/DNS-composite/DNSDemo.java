public class DNSDemo {
    public static void main(String[] args) {
        // Root domain
        Domain root = new Domain(".");

        // Top Level Domain (TLD)
        Domain com = new Domain(".com");
        Domain org = new Domain(".org");

        // Second Level Domain
        Domain google = new Domain("google.com");
        Domain openai = new Domain("openai.org");

        // Subdomains + Hosts
        HostRecord wwwGoogle = new HostRecord("www.google.com", "142.250.183.14");
        HostRecord mailGoogle = new HostRecord("mail.google.com", "142.250.183.17");

        HostRecord apiOpenAI = new HostRecord("api.openai.org", "20.221.36.45");
        HostRecord chatOpenAI = new HostRecord("chat.openai.org", "20.221.41.21");

        // Build hierarchy
        google.add(wwwGoogle);
        google.add(mailGoogle);

        openai.add(apiOpenAI);
        openai.add(chatOpenAI);

        com.add(google);
        org.add(openai);

        root.add(com);
        root.add(org);

        // Traverse DNS structure
        root.show(0);
    }
}
