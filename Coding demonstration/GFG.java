����   = \  
Lambda/GFG  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this LLambda/GFG; fun ?(LLambda/TestInterface;Ljava/lang/Integer;Ljava/lang/Integer;)V    Lambda/TestInterface   print )(Ljava/lang/Integer;Ljava/lang/Integer;)V t LLambda/TestInterface; p1 Ljava/lang/Integer; p2 main ([Ljava/lang/String;)V      ()LLambda/TestInterface;
 ! # " java/lang/Integer $ % valueOf (I)Ljava/lang/Integer;
  '   args [Ljava/lang/String; lambda$0	 , . - java/lang/System / 0 out Ljava/io/PrintStream; 2 java/lang/StringBuilder
 1 	
 1 5 6 7 append -(Ljava/lang/Object;)Ljava/lang/StringBuilder; 9  
 1 ; 6 < -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 1 > ? @ toString ()Ljava/lang/String;
 B D C java/io/PrintStream E F println (Ljava/lang/String;)V 
SourceFile GFG.java BootstrapMethods
 K M L "java/lang/invoke/LambdaMetafactory N O metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; J 
  S *  R  InnerClasses X %java/lang/invoke/MethodHandles$Lookup Z java/lang/invoke/MethodHandles Lookup !               /     *� �    
                           K     	*+,�  �    
   
               	       	      	    	       @     �   
�  �  � &�    
   
    
           ( )  
 *      R     � +� 1Y� 3*� 48� :+� 4� =� A�    
       
                    G    H I     P  Q T U V   
  W Y [ 