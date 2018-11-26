import java.util.ArrayList;

public class Community {

    private Account owner;
    private String description;
    ArrayList<Account> members = new ArrayList<Account>();
    ArrayList<String> members_names = new ArrayList<String>();
    ArrayList<String> join_requests = new ArrayList<String>();
    private String community_name;

    public Community(String name, String description, Account owner)
    {
        this.community_name = name;
        this.owner = owner;
        members.add(owner);
        members_names.add(owner.getName());
        this.description = description;

    }

    public String getName()
    {
        return community_name;
    }

    public Account getOwner()
    {
        return owner;
    }

    public void add_member(Account member)
    {
        members.add(member);
    }

    public void setName(String name)
    {
        this.community_name = name;
    }

    public void setOwner(Account new_owner)
    {
        this.owner = new_owner;
    }

    public void delete()
    {
        int j = 0;

        this.members.get(j).communitys_owner.remove(this);

        for(j=0; j<this.members.size(); j++)
        {
            this.members.get(j).communitys_member.remove(this);
        }
    }


}
