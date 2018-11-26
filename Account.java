import java.util.ArrayList;

public class Account {

    ArrayList<Account> friends = new ArrayList<Account>();
    ArrayList<String> friend_names = new ArrayList<String>();
    ArrayList<Community> communitys_member = new ArrayList<Community>();
    ArrayList<Community> communitys_owner = new ArrayList<Community>();
    ArrayList<String> friend_requests = new ArrayList<String>();
    ArrayList<Message> messages_sent = new ArrayList<Message>();
    ArrayList<Message> messages_received = new ArrayList<Message>();
    private String name;
    private String password;
    private String nick_name;

    public Account(String name, String password, String nick_name)
    {
        this.name = name;
        this.password = password;
        this.nick_name = nick_name;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getNick()
    {
        return this.nick_name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setNick(String nick)
    {
        this.nick_name = nick;
    }

    public void add_request(String friend_name)
    {
        friend_requests.add(friend_name);
    }

    public void add_friend(Account friend)
    {
        friends.add(friend);
        friend_names.add(friend.getName());
    }


}
