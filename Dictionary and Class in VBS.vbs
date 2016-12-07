
'#################  Dictionary using  ############

Dim dic
Set dic = createobject("Scripting.Dictionary")

'-----------------------------------add key and value into dictionary
dic.Add "name","momo"
dic.Add "age", 19
dic.Add "add", "1 street"

'get item by key
msgbox(dic.Item("name"))

'check key if exists
msgbox(dic.Exists("name"))

'------------------------------------use for to get items
dics = dic.Items
For i = 0 To dic.Count-1 Step 1
	msgbox dics(i)&vbCrlf
Next
'------------------------------------use for to get items

'------------------------------------use for each to get items
For each dics in dic
msgbox dics&"+"&dic.Item(dics)
	
Next
'------------------------------------use for each to get items


'#################  Class using  ############

'---------------invoke class method or attribute
'xxx.strName = "ll"
'xxx.intAge = 99
'xxx.aa
'xxx.cc
'zzz.bb


Class clsXXX
public strName, intAge


'print 
Function aa()
On error resume next
'strName = "mm"
'intAge = 30
msgbox(strName)
	
End Function

Function cc()
'	intAge = 40
	msgbox(intAge)
End Function

End Class
Dim xxx
Set xxx = new clsXXX


Class clsZZZ
	
'print
Function bb()
intAge = 25
	msgbox(intAge)
End Function



End Class
Dim zzz
Set zzz = new clsZZZ