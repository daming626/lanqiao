function s=tixing(a,b,n)  
%���sΪ���ֵ���ֵ�⣬����(a,b)Ϊ�������䣬nΪ�ȷ�����ĸ���.
x=a:(b-a)/n:b;
s=(b-a)/n/2*(f(x(1))+f(x(n+1))); 
for i=2:n
    s=s+(b-a)/n*f(x(i));       
end
