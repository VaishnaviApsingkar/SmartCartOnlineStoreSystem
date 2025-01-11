JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java


CLASSES = \
Controller/CommandAddItem.java\
Controller/Command.java\
Controller/CommandRemoveItem.java\
Controller/CommandUpdateItem.java\
Factory/OnlineStoreDefaultFactory.java\
Factory/OnlineStoreFactoryInt.java\
Model/CartItemAbstract.java\
Model/CartItem.java\
Model/Item.java\
Model/ShopCart.java\
Model/OnlineStore.java\
Service/OnlineStoreInt.java\
View/OnlineStoreClient.java\
Service/OnlineStoreServer.java\


default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) -f */*.class

server:
		$(JAVA) Service/OnlineStoreServer

client:
	    $(JAVA) View/OnlineStoreClient
