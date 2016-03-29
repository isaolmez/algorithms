package com.isa.section2.chapter3.exercises;

public class Exercise_2_3_1 {
/****
 * [] => SWAP CANDIDATES
 * {} => PARTITION 
 * 
 * 
 *  E	A	S	Y	Q	U	E	S	T	I	O	N
 *  
 *  E	A	[S]	Y	Q	U	[E]	S	T	I	O	N
 * 	E	A	E	Y	Q	U	S	S	T	I	O	N
 * 
 * 	E	A	[E]	[Y]	Q	U	S	S	T	I	O	N 	// DONT SWAP
 * 	E	A	{E}	Y	W	U	S	S	T	I	O	N	//	SWAP OUTSIDE THE LOOP
 *
 * 
 * E	[A]	// DONT SWAP
 * A	{E}	// SWAP OUTSİDE THE LOOP
 * 
 * 				Y	W	U	S	S	T	I	O	N
 * 
 * 				Y	[W]	U	S	S	T	I	O	[N]
 * 				Y	N	U	S	S	T	I	O	W
 * 
 * 				Y	N	U	S	S	T	I	[O]	[W]	// DONT SWAP HEADPOINTER>=TAILPOINTER
 * 				O	N	U	S	S	T	I	{Y}	W	// SWAP OUTSIDE THE LOOP
 * 
 * 				O	N	U	S	S	T	I
 * 				
 * 				O	N	[U]	S	S	T	[I]
 * 				O	N	I	S	S	T	U
 * 
 * 				O	N	[I]	[S]	S	T	U	// DONT SWAP
 * 				I	N	{O}	S	S	T	U	
 * 
 * 				[I]	[N]	//
 * 				{I}	N	// SWAP OUTSIDE
 * 				
 * 
 * 							S	S	T	U
 * 							
 * 							S [[S]] T	U	// DONT SWAP
 * 							S	{S}	T	U	// SWAP OUTSIDE
 * 
 * 									[T]	[U]
 * 									{T}	U
 * 
 *****FINAL
 *
 * A	E	E	I	N	O	S	S	T	U	Y	W	
 * 
 */
}
