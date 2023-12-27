//Emil Davlityarov
//e.davlityarov@innopolis.university
import java.util.*;
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        Channel channel1 = new Channel("Discovery");
        Channel channel2 = new Channel("Pewdiepie");
        Channel channel3 = new Channel("Innopolis");

        channel1.subscribe(user1);
        channel2.subscribe(user2);
        channel3.subscribe(user1);
        channel3.subscribe(user2);

        channel1.publish(new Video("Animals in Australia"));
        channel2.publish(new Video("Minicraft"));
        channel3.publish(new LiveStream("Report from rainforest"));

        channel3.unsubscribe(user1);

        channel1.publish(new Video("Scuba diving in Great Barrier Reef"));
        channel2.publish(new Shorts("Fortnite montage"));
        channel3.publish(new LiveStream("Jungle survival tips"));
    }
}

interface Observable{
    public void subscribe(User user);
    public void unsubscribe(User user);
    public void publish(Content content);
}
class Channel implements Observable{
    private List<User> userList;
    private String nameChannel;

    Channel(String nameChannel){
        this.nameChannel = nameChannel;
        userList = new ArrayList<>();
    }

    @Override
    public void subscribe(User user){
        userList.add(user);
    }
    @Override
    public void unsubscribe(User user){
        userList.remove(user);
    }
    @Override
    public void publish(Content content){
        for (User user: userList){
            System.out.println(user.getName() + ": " + "Channel " + this.nameChannel + content.update() );
        }
    }
}
class User{
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
interface Content{
    public String update();
}
class Video implements Content{
    private final String nameVideo;
    Video(String nameVideo){
        this.nameVideo = nameVideo;
    }
    @Override
    public String update(){
        return " published new Video: " + this.nameVideo;
    }
}
class Shorts implements Content{
    private final String nameShorts;
    Shorts(String nameShorts){
        this.nameShorts = nameShorts;
    }
    @Override
    public String update(){
        return " published new Shorts: " + this.nameShorts;
    }
}
class LiveStream implements Content{
    private final String nameLiveStream;
    LiveStream(String nameLiveStream){
        this.nameLiveStream= nameLiveStream;
    }
    @Override
    public String update(){
        return " is going live: " + this.nameLiveStream;
    }
}