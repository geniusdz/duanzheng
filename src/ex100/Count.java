package ex100;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Count extends JFrame {
	public static int a,b,cint;//������Ŀ�������������a��b�Լ���0~1���������ʾ�����������c
	public static String c = null;//�Լ����������c(���ַ�����ʽ��ʾ)
	
	public static  JPanel Countpanel;//�����������
	public JPanel Buttonpanel;//������ť��������
	public static JButton Clearbutton;//������հ�ť
	public static JButton Resetbutton;//�������ð�ť
	public static JButton Printfbutton;//������ӡ��ť
	public static JLabel CountLable;//������ȷ��(��ǩ),��ȷ���ڱ�ǩ������
	public static List<Integer> userlist = new ArrayList<>();//�����洢�û��������ļ���
	public static List<JLabel> list = new ArrayList<>();//������Ŀ(��ǩ)����,��Ŀ�ڱ�ǩ�г���
	public static List<JTextField> list1 = new ArrayList<>();//�����û�������������ı��򼯺�
	public static List<Integer> list2 = new ArrayList<>();//����������Ŀ��ȷ�𰸼���
	public static int num ;//�����û���Ե�����
	public static int j=0;
	public static int k=0;
	public static int i=0;
	public Count(){
		//��ʼ����ť
		Clearbutton = new JButton("���");
		Resetbutton = new JButton("����");
		Printfbutton = new JButton("��ӡ");
		
		//���ð�ť��С
		Clearbutton.setSize(50,100);
		Resetbutton.setSize(50,100);
		Printfbutton.setSize(50,100);
		
		//��ʼ���������
		Countpanel = new JPanel();
		Countpanel.setLayout(new GridLayout(25, 4));
		
		//��ʼ����ť���
		Buttonpanel = new JPanel();
		Buttonpanel.setLayout(new FlowLayout());
		Buttonpanel.setSize(600,50);
		Buttonpanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		Buttonpanel.add(Clearbutton);
		CountLable = new JLabel("                         ");
		CountLable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		//����ť�������ť����������
		Buttonpanel.add(Resetbutton);
		Buttonpanel.add(Printfbutton);
		Buttonpanel.add(CountLable);
		
		//Ϊ���������ӱ�ǩ���ı���
		//CountLable();
				
		//���ô�������
		setLayout(new BorderLayout());
		setBounds(100,100,600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		//���������,��ť��������������ָ��λ��
		container.add(Countpanel, BorderLayout.NORTH);
		container.add(Buttonpanel,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new Count().setVisible(true);
		CountLable();
		
	}
	//����CountPanel����е����
	public static void CountLable(){
		for(i=0;i<50;i++){
			JLabel label = new JLabel();
			//�ص�:�����ò��ֵ�������,����setPreferredSize(new Dimension(80, 20))�������ñ�ǩ�Ĵ�С
			//�ص�:�����ܵ���setsize()����
			label.setPreferredSize(new Dimension(80, 20));
			label.setFont(new Font("����",Font.BOLD, 20));
			label.setBorder(BorderFactory.createLineBorder(Color.RED));//���ñ�ǩ�ı߽�
			list.add(label);//listΪ��Ŀ(��ǩ)����,��Ŀ�ڱ�ǩ�г���
			JTextField textField = new JTextField(4);
			list1.add(textField);//list1Ϊ�û�������������ı��򼯺�
		}
		for(i = 0;i<100;i++){//����if-else�������������ǩ���ı���
			if(i%2 == 0){//�������Ϊ0,����ӱ�ǩ
				Countpanel.add(list.get(j));
				j++;
			}else{//�������Ϊ1,������ı���
				Countpanel.add(list1.get(k));
				k++;
			}
			
		}
		CreateRandom();//���ô��������Ŀ�ķ���CreateRandom();
		myAddActionLIstener();//���ð�ť�Ķ�����������myAddActionLIstener()
	}	
	//�������������
	public static void CreateRandom(){
		//int a,b,cint;
		//String c = null;
		Random random = new Random();
		for(JLabel lable:list){//listΪ��Ŀ(��ǩ)����,��Ŀ�ڱ�ǩ�г���
			a = random.nextInt(101);
			b = random.nextInt(101);
			cint = random.nextInt(2);
			switch (cint) {
			case 0:
				c = "+";
				RandomRange();//�����涨�����ⷶΧ����,���Ͳ�����100,�С��0
				lable.setText(a+c+b);
				list2.add(a+b);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
				break;
			default:
				c = "-";
				RandomRange();//�����涨�����ⷶΧ����,���Ͳ�����100,�С��0
				lable.setText(a+c+b);
				list2.add(a-b);//list2Ϊ������Ŀ��ȷ�𰸵ļ���
				break;
			}
		}
	}
	public static void RandomRange(){//�����涨�����ⷶΧ����,���Ͳ�����100,�С��0
		Random r = new Random();
		switch (c) {
		case "+":
			while(a+b>100){
				a = r.nextInt(101);
				b = r.nextInt(101);
				if(a + b <= 100){
					
				}
			}
			break;
		default:
			while(a-b<0){
				a = r.nextInt(101);
				b = r.nextInt(101);
				if(a - b >= 0){
					break;
				}
			}
			break;
		}
	}
	//Ϊ��ť��Ӷ�����������
	public static void myAddActionLIstener() {
		//Ϊ��հ�ť��Ӷ�������
		Clearbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(JLabel clearlable:list){
					clearlable.setText("");
				}
				for(JTextField cleartextField : list1){
					cleartextField.setText("");
				}	
			}
		});
		//Ϊ���ð�ť��Ӷ�������
		Resetbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CreateRandom();
				for(JTextField cleartextField : list1){
					cleartextField.setText("");
				}
			}
		});
		//Ϊ��ӡ��ť��Ӽ���
		Printfbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Integer i;
				Double result;
				num = 0; 
				//��ȡ�û����ı���������ļ�����
				for(i = 0;i<list1.size();i++){//listΪ�û�������������ı��򼯺�
					//Integer.parseInt()�������ڽ��ַ���ת��������
					userlist.add(Integer.parseInt(list1.get(i).getText()));
				}
				//�����û����Ե���Ŀ����
				for(i = 0;i<userlist.size();i++){
					if(userlist.get(i) == list2.get(i)){//list2Ϊ������Ŀ��ȷ�𰸵ļ���
						num++;                    //numΪ�û�������ȷ�ĸ���
					}
				}
				//�����û��������ȷ��
				result = ((num*1.0)/(list.size())*100);
		        CountLable.setText(result + "%");	
			}
		});
	}
}