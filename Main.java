import java.util.Scanner;
import java.util.Objects;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Iface iface = new Iface();
        int op = 1;
        int reop = 1;

        while((op != 3) && (reop != 2))
        {
            System.out.print("Welcome to Iface!\n\n");
            System.out.print("What do you want to do?.\n");
            System.out.print("1 - Sing up;\n");
            System.out.print("2 - Sing in;\n");
            System.out.print("3 - Turn off the system (Stop Program).\n");
            op = input.nextInt();

            if(op == 1)
            {

                System.out.print("\nPlease, enter your name and last name: ");
                input.nextLine();
                String name = input.nextLine();

                while(iface.names.contains(name))
                {
                    System.out.print("\nThis name is already registered, please try other: ");
                    name = input.nextLine();
                }

                System.out.print("Please, enter your password: ");
                String password = input.nextLine();

                System.out.print("Please, enter your nick name: ");
                String nick_name = input.nextLine();

                while(iface.nick_names.contains(nick_name))
                {
                    System.out.print("\nThis nick name is already registered, please try other: ");
                    nick_name = input.nextLine();
                }



                Account new_account = new Account(name, password, nick_name);
                iface.names.add(name);
                iface.nick_names.add(nick_name);
                iface.passwords.add(password);
                iface.add(new_account);

                System.out.print("\nAccount registred!!\n\n");
                System.out.print("Want to return to the Menu or Turn off the system?\n");
                System.out.print("1 - Return to Menu;\n2 - Turn off the system (Stop Program).\n");
                reop = input.nextInt();


            }

            else if(op == 2)
            {
                System.out.print("\nPlease, enter your nick name: ");
                input.nextLine();
                String nick_name = input.nextLine();

                System.out.print("Please, enter your password: ");
                String password = input.nextLine();

                while(!(iface.nick_names.contains(nick_name)) || !iface.passwords.contains(password)
                || ((iface.nick_names.indexOf(nick_name)) != iface.passwords.indexOf(password)))
                {
                    System.out.print("\nNick name or password incorrect, please try again.\n\n");
                    System.out.print("Press 0 to give up.\n");

                    System.out.print("Please, enter your nick name: ");
                    nick_name = input.nextLine();

                    if(Objects.equals(nick_name,"0")) break;

                    System.out.print("Please, enter your password: ");
                    password = input.nextLine();
                }

                    if(!Objects.equals(nick_name,"0"))
                {
                    int index = iface.nick_names.indexOf(nick_name);
                    Account logged = iface.accounts.get(index);
                    String name = iface.names.get(index);

                    System.out.print("\nWelcome " + name + "!\n\n");
                    int op2 = 1;
                    while(op2 != 16)
                    {
                        System.out.print("What do you want to do?\n\n");
                        System.out.print("1 - Change account information;\n");
                        System.out.print("2 - Verify name;\n");
                        System.out.print("3 - Verify password;\n");
                        System.out.print("4 - Verify nick name;\n");
                        System.out.print("5 - Add a friend;\n");
                        System.out.print("6 - Check for friendship requests;\n");
                        System.out.print("7 - Verify friend list;\n");
                        System.out.print("8 - Send a message;\n");
                        System.out.print("9 - Check for messages;\n");
                        System.out.print("10 - Verify message list;\n");
                        System.out.print("11 - Create a community;\n");
                        System.out.print("12 - Join a community;\n");
                        System.out.print("13 - Manage community;\n");
                        System.out.print("14 - Verify community list;\n");
                        System.out.print("15 - Delete account;\n");
                        System.out.print("16 - Log out.\n");
                        op2 = input.nextInt();

                        if(op2 == 1)
                        {
                            System.out.print("\nWhat information do you want to change?\n");
                            System.out.print("1 - Name and last name;\n2 - Password;\n3 - Nick name.\n");
                            int op3 = input.nextInt();

                            if(op3 == 1)
                            {
                                System.out.print("\nYour current name is " + logged.getName() + ".\n\n");

                                System.out.print("Please enter your new name: ");
                                input.nextLine();
                                name = input.nextLine();


                                while(iface.names.contains(name))
                                {
                                    System.out.print("\nThis name is already registered, please try other: ");
                                    name = input.nextLine();
                                }

                                logged.setName(name);
                                iface.set(logged, index);
                                iface.names.set(index, name);
                            }

                            if(op3 == 2)
                            {
                                System.out.print("\nYour current password is " + logged.getPassword() + ".\n\n");
                                System.out.print("Please enter your new password: ");
                                input.nextLine();
                                password = input.nextLine();

                                logged.setPassword(password);
                                iface.set(logged, index);
                                iface.passwords.set(index, password);
                            }

                            if(op3 == 3)
                            {
                                System.out.print("\nYour current nick name is " + logged.getNick() + ".\n\n");
                                System.out.print("Please enter your new nick name: ");
                                input.nextLine();
                                nick_name = input.nextLine();

                                while(iface.nick_names.contains(nick_name))
                                {
                                    System.out.print("\nThis nick name is already registered, please try other: ");
                                    nick_name = input.nextLine();
                                }

                                logged.setNick(nick_name);
                                iface.set(logged, index);
                                iface.nick_names.set(index, nick_name);
                            }

                            System.out.print("\nDone!\n\n");
                            System.out.print("Returning to the main menu.\n\n");
                        }

                        if(op2 == 2)
                        {
                            System.out.print("\nYour current name is " + logged.getName() + ".\n\n");

                            System.out.print("Returning to the main menu.\n\n");
                        }

                        if(op2 == 3)
                        {
                            System.out.print("\nYour current password is " + logged.getPassword() + ".\n\n");

                            System.out.print("Returning to the main menu.\n\n");
                        }

                        if(op2 == 4)
                        {
                            System.out.print("\nYour current nick name is " + logged.getNick() + ".\n\n");

                            System.out.print("Returning to the main menu.\n\n");
                        }

                        if(op2 == 5)
                        {
                            System.out.print("\nPlease, enter the name of your possible friend: ");
                            input.nextLine();
                            String friend_name = input.nextLine();

                            while((!iface.names.contains(friend_name)) && (!Objects.equals(friend_name,"0")))
                            {
                                System.out.print("\nAccount not found, please try other name: \n");
                                System.out.print("Press 0 to give up.\n");
                                friend_name = input.nextLine();
                            }


                            if(!Objects.equals(friend_name,"0"))
                            {
                                int index_friend = iface.names.indexOf(friend_name);
                                Account friend = iface.accounts.get(index_friend);
                                friend.add_request(name);

                                System.out.print("\nWe sent a friend request to " + friend_name + ".\n");
                            }
                            System.out.print("\nReturning to the main menu.\n\n");

                        }

                        if(op2 == 6)
                        {
                            if(logged.friend_requests.isEmpty())
                            {
                                System.out.print("\nYou don't have friend requests!\n");
                            }

                            else
                            {
                                int i;
                                for(i = 0; i<logged.friend_requests.size(); i++)
                                {
                                    String friend_name = logged.friend_requests.get(i);

                                    System.out.print("\nYou have a friend request from " + friend_name + ".\n\n");
                                    System.out.print("To accept, press 1;\nTo refuse, press 2.\n");
                                    int friend_code;
                                    friend_code = input.nextInt();

                                    if(friend_code == 1)
                                    {
                                        int friend_index = iface.names.indexOf(friend_name);
                                        Account friend = iface.accounts.get(friend_index);
                                        logged.add_friend(friend);
                                        friend.add_friend(logged);
                                        logged.friend_requests.remove(i);
                                    }
                                }
                            }

                            System.out.print("\nReturning to the main menu.\n\n");
                        }

                        if(op2 == 7)
                        {

                            if(logged.friends.isEmpty()) System.out.print("\nYou don't have friends yet!\n\n");

                            else
                            {
                                System.out.print("\nYou're friend of: \n\n");
                                int i;
                                for(i=0; i<logged.friends.size(); i++)
                                {
                                    if(i+1 == logged.friends.size()) System.out.print(logged.friends.get(i).getNick() + ".\n\n");
                                    else System.out.print(logged.friends.get(i).getNick() + ";\n");

                                }
                            }

                            System.out.print("Returning to the main menu.\n\n");
                        }

                        if(op2 == 8)
                        {
                            if(logged.friends.isEmpty()) System.out.print("\nYou don't have friends yet!\n\n");

                            else
                            {
                                System.out.print("\nPlease, enter the receiver name: ");
                                input.nextLine();
                                String receiver_name = input.nextLine();

                                while(!logged.friend_names.contains(receiver_name))
                                {
                                    System.out.print("\nFriend not found. Please, try another:\n");
                                    receiver_name = input.nextLine();
                                }

                                    System.out.print("\nPlease, enter your message:\n");
                                    String body = input.nextLine();

                                    int receiver_index = iface.names.indexOf(receiver_name);
                                    Account receiver = iface.accounts.get(receiver_index);

                                    Message message = new Message(body, receiver, logged);

                                    receiver.messages_received.add(message);
                                    logged.messages_sent.add(message);

                                    System.out.print("\nMessage sent!\n\n");
                                    System.out.print("Returning to main menu.\n\n");

                            }
                        }

                        if(op2 == 9)
                        {
                            int i;
                            int aux = 0;

                            for(i=0; i<logged.messages_received.size(); i++)
                            {
                                if(logged.messages_received.get(i).read) aux++;
                            }

                            if(aux == logged.messages_received.size()) System.out.print("\nYou don't have new messages!\n\n");

                            else
                            {

                                for(i=0; i<logged.messages_received.size(); i++)
                                {
                                    if (!logged.messages_received.get(i).read)
                                    {
                                        System.out.print("You have a new message from " + logged.messages_received.get(i).getSender() + ".\n");
                                        System.out.print("\n" + logged.messages_received.get(i).getBody() + "\n");
                                        logged.messages_received.get(i).read = true;

                                        System.out.print("\nDo you want to answer?\n");
                                        System.out.print("Press 1 to yes;\nPress 2 to no.\n");
                                        input.nextLine();
                                        int answer = input.nextInt();

                                        if (answer == 1)
                                        {
                                            System.out.print("\nPlease, enter your message:\n");
                                            input.nextLine();
                                            String body = input.nextLine();

                                            int receiver_index = iface.names.indexOf(logged.messages_received.get(i).getSender());
                                            Account receiver = iface.accounts.get(receiver_index);

                                            Message message = new Message(body, receiver, logged);

                                            receiver.messages_received.add(message);
                                            logged.messages_sent.add(message);

                                            System.out.print("\nMessage sent!\n\n");
                                            System.out.print("Returning to main menu.\n\n");
                                        }
                                    }
                                }
                            }
                        }

                        if(op2 == 10)
                        {
                            System.out.print("\nMessages received:\n\n");
                            int i;

                            if(logged.messages_received.isEmpty()) System.out.print("None");

                            else
                            {
                                for(i=0; i<logged.messages_received.size(); i++)
                                {
                                    System.out.print("From: " + logged.messages_received.get(i).getSender() + "\n");
                                    System.out.print(logged.messages_received.get(i).getBody() + "\n\n");
                                }
                            }

                            if(logged.messages_sent.isEmpty()) System.out.print("None");

                            else
                            {
                                System.out.print("\nMessages sent:\n\n");
                                for(i=0; i<logged.messages_sent.size(); i++)
                                {
                                    System.out.print("To: " + logged.messages_sent.get(i).getReceiver() + "\n");
                                    System.out.print(logged.messages_sent.get(i).getBody() + "\n\n");
                                }
                            }
                        }

                        if(op2 == 11)
                        {
                            String community_name;
                            System.out.print("\nPlease, enter the name of your community: ");
                            input.nextLine();
                            community_name = input.nextLine();

                            while(iface.communitys_names.contains(community_name))
                            {
                                System.out.print("\nSorry, this community already exist, please try other: ");
                                community_name = input.nextLine();
                            }

                            System.out.print("Please, enter the description of your community: ");
                            String description = input.nextLine();

                            System.out.print("\nCommunity creation finished!\n\n");
                            System.out.print("Returning to the main menu.\n\n");

                            Community my_community = new Community(community_name, description, logged);
                            iface.communitys_names.add(community_name);
                            iface.communitys.add(my_community);
                            logged.communitys_owner.add(my_community);
                            logged.communitys_member.add(my_community);

                        }

                        if(op2 == 12)
                        {
                            String community_name;
                            System.out.print("\nPlease, enter the name of the community: ");
                            input.nextLine();
                            community_name = input.nextLine();

                            while(!iface.communitys_names.contains((community_name)))
                            {
                                System.out.print("\nSorry, community not found. Try another:\n");
                                System.out.print("Press 0 to give up.\n");
                                community_name = input.nextLine();

                                if(Objects.equals(community_name, "0")) break;
                            }

                            if(!Objects.equals(community_name, "0"))
                            {
                                int index_community = iface.communitys_names.indexOf(community_name);
                                Community Community = iface.communitys.get(index_community);

                                while(Community.members.contains(logged))
                                {
                                    System.out.print("\nYou're already a member of that community! Please, try another: ");
                                    community_name = input.nextLine();
                                }

                                index_community = iface.communitys_names.indexOf(community_name);
                                Community = iface.communitys.get(index_community);

                                Community.join_requests.add(logged.getNick());

                                System.out.print("\nWe sent your join request to the community's owner!\n\n");
                                System.out.print("Returning to the main menu.\n\n");
                            }
                        }

                        if(op2 == 13)
                        {
                            if(logged.communitys_owner.isEmpty())
                            {
                                System.out.print("\nSorry, you don't have communities to manage yet.\n\n");
                            }

                            else
                            {
                                int i, manage, op_manage;
                                Community open;
                                for(i=0; i<logged.communitys_owner.size(); i++)
                                {
                                    System.out.print("\nDo you want to manage " + logged.communitys_owner.get(i).getName() + "?\n");
                                    System.out.print("1 - Yes;\n2 - No.\n");
                                    input.nextLine();
                                    manage = input.nextInt();

                                    if(manage == 1)
                                    {
                                        open = logged.communitys_owner.get(i);
                                        op_manage = 1;

                                        while(op_manage != 6)
                                        {
                                            System.out.print("\nWhat do you want to do? \n");
                                            System.out.print("1 - Add member;\n");
                                            System.out.print("2 - Check join requests;\n");
                                            System.out.print("3 - Remove member;\n");
                                            System.out.print("4 - Check members;\n");
                                            System.out.print("5 - Delete community;\n");
                                            System.out.print("6 - Get out from the community;\n");
                                            op_manage = input.nextInt();

                                            if(op_manage == 1)
                                            {
                                                String member_name;
                                                System.out.print("\nPlease, enter the account name: ");
                                                input.nextLine();
                                                member_name = input.nextLine();

                                                while (!iface.names.contains(member_name))
                                                {
                                                    System.out.print("\nSorry, account doesn't exist. Please, try other: ");

                                                    member_name = input.nextLine();
                                                }

                                                while(open.members_names.contains(member_name))
                                                {
                                                    System.out.print("\nAccount is already a member! Please, try another: ");
                                                    member_name = input.nextLine();
                                                }

                                                int member_index = iface.names.indexOf(member_name);
                                                Account member = iface.accounts.get(member_index);

                                                member.communitys_member.add(open);
                                                open.add_member(member);
                                                open.members_names.add(member.getName());

                                                System.out.print("\nMember added!\n\n");
                                                System.out.print("Returning to the community menu.\n\n");
                                            }

                                            if(op_manage == 2)
                                            {
                                                if(open.join_requests.isEmpty())
                                                {
                                                    System.out.print("\nThe community doesn't have join requests.\n");
                                                }

                                                else
                                                {
                                                    for(i=0; i<open.join_requests.size(); i++)
                                                    {
                                                        System.out.print("\nDo you want to accept " + open.join_requests.get(i));
                                                        System.out.print(" on your community?\n");
                                                        System.out.print("1 - Yes;\n2 - No.\n");
                                                        int accept = input.nextInt();


                                                        if(accept == 1)
                                                        {
                                                            int member_index = iface.nick_names.indexOf(open.join_requests.get(i));
                                                            Account member = iface.accounts.get(member_index);

                                                            member.communitys_member.add(open);
                                                            open.add_member(member);
                                                            open.members_names.add(member.getName());
                                                            open.join_requests.remove(i);
                                                            System.out.print("\nRequest accepted!\n\n");
                                                            System.out.print("Returning to the community menu.\n\n");
                                                        }

                                                        if(accept == 0)
                                                        {
                                                            System.out.print("\nRequest denied!\n\n");
                                                            System.out.print("Returning to the community menu.\n");
                                                        }
                                                    }

                                                }
                                            }

                                            if(op_manage == 3)
                                            {
                                                String member_name;
                                                System.out.print("\nPlease, enter the name of the member: ");
                                                input.nextLine();
                                                member_name = input.nextLine();

                                                while(!open.members_names.contains(member_name))
                                                {
                                                    System.out.print("\nMember not found! Try another: ");
                                                    member_name = input.nextLine();
                                                }

                                                int member_index = open.members_names.indexOf(member_name);
                                                Account member = open.members.get(member_index);

                                                open.members.remove(member);
                                                open.members_names.remove(member_name);
                                                member.communitys_member.remove(open);

                                                System.out.print("\nMember kicked!\n\n");
                                                System.out.print("Returning to the community menu.\n");
                                            }

                                            if(op_manage == 4)
                                            {
                                                System.out.print("\nAre members of your community: \n\n");
                                                for(i=0; i<open.members.size(); i++)
                                                {
                                                    System.out.print(open.members.get(i).getNick());
                                                    if(i+1 == open.members.size()) System.out.print(".\n");
                                                    else System.out.print(";\n");
                                                }
                                                System.out.print("\nReturning to the community menu.\n\n");
                                            }

                                            if(op_manage == 5)
                                            {
                                                open.delete();
                                                iface.communitys.remove(open);
                                                iface.communitys_names.remove(open.getName());
                                                System.out.print("\nCommunity deleted!\n\n");
                                                System.out.print("Returning to the main menu.\n\n");
                                                op_manage = 6;
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }

                        if(op2 == 14)
                        {
                            if(logged.communitys_member.isEmpty())
                            {
                                System.out.print("\nYou aren't member of a community yet!\n\n");
                            }

                            else
                            {
                                System.out.print("\nYou're member of:\n\n");
                                int i;
                                for(i=0; i<logged.communitys_member.size(); i++)
                                {
                                    System.out.print(logged.communitys_member.get(i).getName());
                                    if(i+1 == logged.communitys_member.size()) System.out.print(".\n\n");
                                    else System.out.print(";\n");
                                }
                            }

                        }

                        if(op2 == 15)
                        {
                            int i;
                            for(i=0; i<logged.friends.size(); i++)
                            {
                                logged.friends.get(i).friends.remove(logged);
                            }

                            for(i=0; i<logged.communitys_member.size(); i++)
                            {
                                logged.communitys_member.get(i).members.remove(logged);
                                logged.communitys_member.get(i).members_names.remove(logged.getName());
                            }

                            for(i=0; i<logged.communitys_owner.size(); i++)
                            {
                                iface.communitys.remove(logged.communitys_owner.get(i));
                                iface.communitys_names.remove(logged.communitys_owner.get(i).getName());
                                logged.communitys_owner.get(i).delete();
                            }

                            iface.names.remove(logged.getName());
                            iface.passwords.remove(logged.getPassword());
                            iface.nick_names.remove(logged.getNick());
                            iface.accounts.remove(logged);

                            System.out.print("\nAccount Deleted!\n\n");
                            System.out.print("Returning to the login menu.\n\n");

                            op2 = 16;
                        }
                    }
                }
            }
        }
    }
}
