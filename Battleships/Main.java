����   @ �
      java/lang/Object <init> ()V  java/util/Scanner	 
     java/lang/System in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V  org/koan/battleships/Battlemap	 
    out Ljava/io/PrintStream;  Enter your name: 
      java/io/PrintStream print (Ljava/lang/String;)V
  ! " # nextLine ()Ljava/lang/String; % Enter your opponent name:    ' ( ) makeConcatWithConstants 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 + , - . / java/lang/Integer parseInt (Ljava/lang/String;)I 1 Enter 1 or 2
  3 4  println 6 java/lang/Exception 8 Enter the number 1 or 2 : org/koan/battleships/Mymap
 9 <   > org/koan/battleships/Opponent
 = <
 9 A B  putShips
 9 D E F getMasts ()I
 = D
  I J  shoot L ,It's a tie! Good leadership of both of You!! N !Nothing happened. Do not give up! P +Congratulations!!! You have won the game :) R org/koan/battleships/Main Code LineNumberTable LocalVariableTable this Lorg/koan/battleships/Main; main ([Ljava/lang/String;)V e Ljava/lang/Exception; args [Ljava/lang/String; sc Ljava/util/Scanner; result I priority ![Lorg/koan/battleships/Battlemap; masts [I myName Ljava/lang/String; opponentName mymap Lorg/koan/battleships/Mymap; opponent Lorg/koan/battleships/Opponent; StackMapTable ] c e r java/lang/String 
SourceFile 	Main.java BootstrapMethods w (Who starts?
1. 
2. 
Enter the number:  y
 z { | ( } $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup ! Q           S   /     *� �    T        U        V W   	 X Y  S  G  	   �� Y� 	� L=� N�
:� � +�  :� $� +�  :� � &  � +�  � *=� � � 0� 2� � ���:� 7� 2��Ļ 9Y� ;:� =Y� ?:� -S-S� -S-S� @� C� � G� -2� H-2� H���� C� � G� � K� 2� � C� � M� 2� � O� 2�  B _ e 5  T   � "              %  -  3  B  J  T  _  b # e ! g " o # r % } & � ) � * � + � - � . � 1 � 3 � 4 � 5 � : � ; � = � > � @ � D U   f 
 g  Z [    � \ ]    � ^ _   � ` a   � b c   � d e  % � f g  3 � h g  } � i j  � w k l  m   2 � 3  n  o p q q  +B 5� ' 9 =	  s    t u     x  v ~   
   � � 