# Description:
In this task we will assume that YouTube is a video platform that allows content creators to create
three types of content: standard videos, live streaming, and “Shorts” videos. It should allow users
to subscribe to channels and be informed about new content on these channels. All users that
are subscribed to a specific channel should be notified about new content of any type on this
channel. Examples of notifications that should be displayed to a user are:
- Channel Discovery published new Video: Animals in Australia
- Channel Pewdiepie published new Shorts: Minicraft
- Channel Innopolis is going live: Report from Students Day

Additionally, users should be able to unsubscribe from the channel, and they should not receive
any new notifications from this channel after unsubscribing.
I implemented the described app using the Observer design pattern. Mandatory classes to
implement are:
- class Channel (should enable to subscribe
- class User
- interface Content
- class Video implements Content
- class Shorts implements Content
- class LiveStream implements Content
